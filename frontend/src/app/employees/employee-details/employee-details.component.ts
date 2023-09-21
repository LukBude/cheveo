import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { Employee } from "../employee";
import { EmployeeHttpService } from "../employee-http.service";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-employee-details",
  templateUrl: "./employee-details.component.html",
  styleUrls: ["./employee-details.component.scss"],
  imports: [CommonModule, FormsModule],
  standalone: true
})
export class EmployeeDetailsComponent implements OnInit {
  employee?: Employee;

  constructor(private route: ActivatedRoute, private employeeHttpService: EmployeeHttpService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.employeeHttpService.getEmployee(+params.get("id")!)
        .subscribe(employee => this.employee = employee);
    });
  }

  onUpdateButtonClick() {
    this.employeeHttpService.updateEmployee(this.employee!, this.employee!.id).subscribe();
  }
}

import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../employee";
import { EmployeeHttpService } from "../employee-http.service";
import { CommonModule } from "@angular/common";
import { Router } from "@angular/router";

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.scss"],
  standalone: true,
  imports: [CommonModule],
  providers: [EmployeeHttpService]
})
export class EmployeeListComponent implements OnInit {
  employees$: Observable<Employee[]> = this.employeeHttpService.employees$;

  constructor(
    private router: Router,
    private employeeHttpService: EmployeeHttpService) {
  }

  ngOnInit(): void {
    this.employeeHttpService.loadEmployees();
  }

  onDeleteClick(employee: Employee): void {
    this.employeeHttpService.removeEmployee(employee.id);
  }

  onEmployeeClick(employee: Employee) {
    this.router.navigate([`employees/${employee!.id}`]).catch(error => console.log(error));
  }
}

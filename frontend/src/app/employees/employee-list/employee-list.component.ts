import { Component } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "../employee";
import { EmployeeHttpService } from "../employee-http.service";
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-employee-list",
  templateUrl: "./employee-list.component.html",
  styleUrls: ["./employee-list.component.scss"],
  standalone: true,
  imports: [CommonModule],
  providers: [EmployeeHttpService]
})
export class EmployeeListComponent {
  employees$: Observable<Employee[]> = this.employeeHttpService.employees$;

  constructor(private employeeHttpService: EmployeeHttpService) {
    this.employeeHttpService.loadEmployees();
  }

  onDeleteClick(employee: Employee): void {
    this.employeeHttpService.removeEmployee(employee.id);
  }
}

import { Component } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { NgIf } from "@angular/common";
import { Employee } from "../employee";
import { EmployeeHttpService } from "../employee-http.service";

@Component({
  selector: "app-create-employee",
  templateUrl: "./create-employee.component.html",
  styleUrls: ["./create-employee.component.scss"],
  imports: [
    FormsModule,
    NgIf,
    ReactiveFormsModule
  ],
  standalone: true
})
export class CreateEmployeeComponent {
  employee: Employee = {
    firstName: "",
    lastName: "",
    birthDate: "",
    address: {
      city: "",
      zip: "",
      street: "",
      number: ""
    },
    phone: ""
  };

  constructor(private employeeHttpService: EmployeeHttpService) {
  }

  onCreateButtonClick() {
    this.employeeHttpService.createEmployee(this.employee).subscribe();
  }
}

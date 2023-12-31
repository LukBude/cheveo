import { Routes } from "@angular/router";
import { EmployeeListComponent } from "./employees/employee-list/employee-list.component";

export const APP_ROUTES: Routes = [
  {
    path: "",
    pathMatch: "full",
    redirectTo: "employees"
  },
  {
    path: "employees",
    component: EmployeeListComponent
  },
  {
    path: "employees/create",
    loadComponent: () =>
      import("./employees/create-employee/create-employee.component").then(c => c.CreateEmployeeComponent)
  },
  {
    path: "employees/:id",
    loadComponent: () =>
      import("./employees/employee-details/employee-details.component").then(c => c.EmployeeDetailsComponent)
  }
];

import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, tap } from "rxjs";
import { Employee } from "./employee";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: "root"
})
export class EmployeeHttpService {
  private employeesSubject = new BehaviorSubject<Employee[]>([]);

  employees$ = this.employeesSubject.asObservable();

  constructor(private httpClient: HttpClient) {
  }

  loadEmployees(): void {
    this.httpClient.get<Employee[]>(environment.employeesUrl).subscribe(
      employees => this.employeesSubject.next(employees)
    );
  }

  removeEmployee(id: number): void {
    this.httpClient.delete<void>(`${environment.employeesUrl}/${id}`)
      .pipe(tap(() => this.loadEmployees())).subscribe();
  }
}

import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { BehaviorSubject, Observable, tap } from "rxjs";
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

  getEmployee(id: number): Observable<Employee> {
    return this.httpClient.get<Employee>(`${environment.employeesUrl}/${id}`);
  }

  removeEmployee(id: number): void {
    this.httpClient.delete<void>(`${environment.employeesUrl}/${id}`)
      .pipe(tap(() => this.loadEmployees())).subscribe();
  }

  updateEmployee(employee: Employee, id: number): Observable<Employee> {
    return this.httpClient.put<Employee>(`${environment.employeesUrl}/${id}`, employee)
      .pipe(tap(() => this.loadEmployees()));
  }

  createEmployee(employee: Employee): Observable<Employee> {
    return this.httpClient.post<Employee>(`${environment.employeesUrl}`, employee)
      .pipe(tap(() => this.loadEmployees()));
  }
}

import { Address } from "./address";

export interface Employee {
  id?: number,
  firstName: string,
  lastName: string,
  birthDate: string,
  address: Address,
  phone: string
}

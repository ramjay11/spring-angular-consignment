import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConsignmentModel } from './consignmentmodel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConsignmentService {

  constructor(private http:HttpClient) { }

  // Retrieve data from the backend
  public getConsignment() : Observable<ConsignmentModel[]>{
    // Promises and Observables are both used for handling asynchronous operations
    return this.http.get<ConsignmentModel[]>("http://localhost:8081/consignment");
  }
}

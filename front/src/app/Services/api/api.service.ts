import { Injectable } from '@angular/core';
import { billListI } from '../../Models/billlist.interface';
import { ResponseI } from 'src/app/Models/response.interface';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  url:string= "localhost:8080/";

  constructor(private http:HttpClient) { }

  getAllBills():Observable<billListI[]>{
    let address = this.url + "parking-app/api/v1/bills";
    return  this.http.get<billListI[]>(address);
  }

  getSingleBill(plate: string | null):Observable<billListI>{
    let address = this.url + "/parking-app/api/v1/bills/get_parked?plate=XXX-XXX" +plate;
    return  this.http.get<billListI>(address);
  }

}

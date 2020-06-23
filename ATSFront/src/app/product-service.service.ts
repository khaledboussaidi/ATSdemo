import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) { }
  host = 'http://localhost:8084';


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };
public getProducts(pagenuber){
  return this.http.get(this.host + '/products?pagenumber=' + pagenuber, this.httpOptions);
}
public  getProductsById(id){
  return this.http.get(this.host + '/products/' + id , this.httpOptions);

}
}

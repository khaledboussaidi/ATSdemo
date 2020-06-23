import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {ProductServiceService} from '../product-service.service';

@Component({
  selector: 'app-pagelist',
  templateUrl: './pagelist.component.html',
  styleUrls: ['./pagelist.component.css']
})
export class PagelistComponent implements OnInit {
products: any;
pagenumber = 0;
listofreview = Array();
  constructor(private service: ProductServiceService, private router: Router) { }

  // @ts-ignore
  // @ts-ignore
  ngOnInit(): void {
    // tslint:disable-next-line:triple-equals
    if (this.pagenumber == 0){
      const resp = this.service.getProducts(this.pagenumber);
      resp.subscribe((data) => {
        this.products = data['content'];

      });

    }


  }

  public AVG(data){
// tslint:disable-next-line:prefer-const
   let sum = 0;
   this.listofreview = data;
    // tslint:disable-next-line:prefer-for-of
   for (let i = 0; i < this.listofreview.length; i++){
     let rating=this.listofreview[0];
     sum = sum + rating['rating'];
   }
    console.log(data);
   return sum / this.listofreview.length;
  }
  public nextPage(){
    this.pagenumber=this.pagenumber+1;
    const resp = this.service.getProducts(this.pagenumber);
    resp.subscribe((data) => {
      this.products = data['content'];

    });

}}

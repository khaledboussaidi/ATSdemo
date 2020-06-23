import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from '../product-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-pagedetail',
  templateUrl: './pagedetail.component.html',
  styleUrls: ['./pagedetail.component.css']
})
export class PagedetailComponent implements OnInit {

  constructor(private service: ProductServiceService, private router: Router, private route: ActivatedRoute) { }
  product: any;
  id: string;
  ngOnInit(): void {
    this.route.params.subscribe(params =>
    {
      this.id = params.id;
      console.log(this.id);
    });
    const resp = this.service.getProductsById( this.id);
    resp.subscribe((data) => {
      this.product = data;

    });
  }

}

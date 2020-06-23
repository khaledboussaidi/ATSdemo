import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {ProductServiceService} from './product-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ATSFront';

  constructor(private service: ProductServiceService, private router: Router) {
  }
}

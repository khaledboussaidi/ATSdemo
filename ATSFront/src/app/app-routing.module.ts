import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterModule, Routes} from '@angular/router';
import {PagelistComponent} from './pagelist/pagelist.component';
import {ProductServiceService} from './product-service.service';
import {PagedetailComponent} from './pagedetail/pagedetail.component';

const routes: Routes = [
  { path: 'products', component: PagelistComponent },
  { path: 'product/:id', component: PagedetailComponent },

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  constructor(private service: ProductServiceService, private router: Router) {
  }
}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class ReviewModule {
  rating: number;
  content: string;


  constructor(rating: number, content: string) {
    this.rating = rating;
    this.content = content;
  }
}

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';




@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})

export class ProductModule {
  color: string;
  category: string;
  productName: string;
  price: string;
  description: string;
  tag: string;
  listreveiw = [];

  // tslint:disable-next-line:max-line-length
  constructor(color: string, category: string, productName: string, price: string, description: string, tag: string, productMaterial: string, imageUrl: string, createdAt: string) {
    this.color = color;
    this.category = category;
    this.productName = productName;
    this.price = price;
    this.description = description;
    this.tag = tag;
    this.productMaterial = productMaterial;
    this.imageUrl = imageUrl;
    this.createdAt = createdAt;
  }

  productMaterial: string;
  imageUrl: string;
  createdAt: string;
}

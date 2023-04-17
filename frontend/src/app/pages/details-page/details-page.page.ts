import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroup, FormsModule, FormBuilder, Validators, ReactiveFormsModule  } from '@angular/forms';
import { IonicModule } from '@ionic/angular';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Ihotel_details } from 'src/app/models/Ihotel_details';
import { DataService } from 'src/app/services/data.service';
import { CarouselComponent, CarouselControlComponent, CarouselIndicatorsComponent, CarouselInnerComponent, CarouselItemComponent, CarouselModule } from '@coreui/angular';
import { BrowserModule } from '@angular/platform-browser';
import { trigger, transition, style, animate } from '@angular/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxStarRatingModule } from 'ngx-star-rating';
import { StarRatingComponent } from 'src/app/shared/star-rating/star-rating.component';


@Component({
  selector: 'app-details-page',
  templateUrl: './details-page.page.html',
  styleUrls: ['./details-page.page.scss'],
  standalone: true,
  imports: [IonicModule,CommonModule, CarouselModule,RouterModule, StarRatingComponent, CarouselComponent, CarouselControlComponent, CarouselIndicatorsComponent,CarouselInnerComponent, CarouselItemComponent]
})
export class DetailsPagePage implements OnInit {
  hotel_details!: Ihotel_details;
  slides: any[] = new Array(3).fill({id: -1, src: '', title: '', subtitle: ''});

  constructor(private route: ActivatedRoute, private data: DataService, private fb: FormBuilder) {
  }


  ngOnInit() {
    this.slides[0] = {
      src: 'https://coreui.io/angular/docs/assets/img/react.jpg',
    };
    this.slides[1] = {
      src: 'https://coreui.io/angular/docs/assets/img/vue.jpg',
    }
    this.slides[2] = {
      src: 'https://coreui.io/angular/docs/assets/img/angular.jpg',
    }
    this.route.params.subscribe(params => {
      // Here you can access the id parameter from the URL
      const id = params['id'];
      console.log(id)

      // You can then use the id to fetch the corresponding hotel data from your data service
      this.data.gethoteldetails(id).then((details) => {
        this.hotel_details = details;
      });
    });
  }

}

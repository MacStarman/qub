import { Component, Input, OnInit } from '@angular/core';
import { IonicModule } from '@ionic/angular';
import { Ihotel } from 'src/app/models/Ihotel';
import { StarRatingComponent } from '../star-rating/star-rating.component';

@Component({
  selector: 'app-hotel-card',
  templateUrl: './hotel-card.component.html',
  styleUrls: ['./hotel-card.component.scss'],
  standalone: true,
  imports: [IonicModule, StarRatingComponent]
})
export class HotelCardComponent  implements OnInit {
  @Input()
  hotel!: Ihotel;

  constructor() { }

  ngOnInit() {}

}

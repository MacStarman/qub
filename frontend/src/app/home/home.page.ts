import { CommonModule, JsonPipe } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { IonicModule, IonRouterOutlet } from '@ionic/angular';
import { Ihotel } from '../models/Ihotel';
import { DataService } from '../services/data.service';
import { HotelCardComponent } from '../shared/hotel-card/hotel-card.component';
import { SearchbarComponent } from '../util/searchbar/searchbar.component';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports: [IonicModule, SearchbarComponent, HotelCardComponent, CommonModule, RouterModule, HttpClientModule],
})
export class HomePage implements OnInit {
  handleSearchTriggered() {
    this.show = true;
  }
  hotels!: Ihotel[];
  show: boolean = false;

  constructor(private data: DataService, private router: Router) {}

  navigateToHotelDetails(hotel: Ihotel) {
    console.log(hotel.id)
    this.router.navigate(['hotel-details', hotel.id]);
  }

  ngOnInit() {
    this.data.gethotels().then((hotels) => {
      this.hotels = hotels;
    });
  }
}

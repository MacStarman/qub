import { CommonModule, JsonPipe } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { IonicModule, IonRouterOutlet } from '@ionic/angular';
import { Ihotel } from '../models/Ihotel';
import { IRequest } from '../models/IRequest';
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
  handleRequest(request: IRequest) {
    // Handle the request here
    console.log('Received request in parent component:', request);
    // You can pass the request to other functions or services as needed
    // Make API POST call with the request in the JSON body
    this.http.post<Ihotel[]>('http://qube/hotels', request)
      .subscribe(
        (response) => {
          console.log('API response:', response);
          this.hotels = response;
          this.show = true;
        },
        (error) => {
          console.error('API error:', error);
          // Handle the error from the API as needed
        }
      );
  }

  hotels!: Ihotel[];
  show: boolean = false;

  constructor(private data: DataService, private router: Router, private http: HttpClient) {}

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

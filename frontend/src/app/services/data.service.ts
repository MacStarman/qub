import { Injectable } from '@angular/core';
import { Ihotel } from '../models/Ihotel';
import { Ihotel_details } from '../models/Ihotel_details';
import { IRequest } from '../models/IRequest';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {

  rootURL = '/api';

  gethotels(): Promise<Ihotel[]> {
    const hotels: Ihotel[] = [
      {
        id: 1,
        name: 'My Hotel',
        location: 'New York',
        thumbnail:
          'https://digital.ihg.com/is/image/ihg/voco-new-york-6671510166-16x9',
        price: 120.2,
        short_description: 'A cozy hotel in the heart of New York',
        rating: 4,
      },
      {
        id: 2,
        name: 'Another Hotel',
        location: 'Paris',
        thumbnail:
          'https://digital.ihg.com/is/image/ihg/voco-new-york-6671510166-16x9',
        price: 150,
        short_description: 'A luxurious hotel in the heart of Paris',
        rating: 3,
      },
    ];
    // return this.http.get(this.rootURL + '/users');
    return Promise.resolve(hotels);
  }

  gethoteldetails(id: number): Promise<Ihotel_details>{
    const hotelDetails: Ihotel_details = {
      id: 1,
      name: 'My Hotel',
      description: 'A beautiful hotel with a great view',
      facilities: ['Free WiFi', 'Swimming pool', 'Gym'],
      images: ['https://coreui.io/angular/docs/assets/img/react.jpg', 'https://coreui.io/angular/docs/assets/img/vue.jpg'],
      reviews: [
        {
          name: 'John Doe',
          comment: 'Great experience!',
          stars: 2
        },
        {
          name: 'Jane Smith',
          comment: 'I had a pleasant stay.',
          stars: 4
        }
      ]
    };

    return Promise.resolve(hotelDetails);
  }

  search(search: IRequest): Boolean{
    console.log("SENDING")
    return true;
  }

  constructor(private http: HttpClient) {}
}

import { Injectable } from '@angular/core';
import { Ihotel } from '../models/Ihotel';
import { Ihotel_details } from '../models/Ihotel_details';
import { IRequest } from '../models/IRequest';
import { HttpClient } from '@angular/common/http';
import { firstValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DataService {

  rootURL = '/api';

  gethotels(): Promise<Ihotel[]> {
    const hotels$ = this.http.get<Ihotel[]>(this.rootURL + '/hotels');
    return firstValueFrom(hotels$);
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

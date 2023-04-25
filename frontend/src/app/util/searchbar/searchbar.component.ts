import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IonDatetime, IonicModule } from '@ionic/angular';
import { DataService } from 'src/app/services/data.service';
import { IRequest } from 'src/app/models/IRequest'

@Component({
  selector: 'app-searchbar',
  standalone: true,
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css'],
  imports: [IonicModule, FormsModule],
})
export class SearchbarComponent implements OnInit {
  isToastOpen = false;
  location!: string;
  begin_date!: Date;
  end_date!: Date;
  people!: number;

  setOpen(isOpen: boolean) {
    this.isToastOpen = isOpen;
  }

  start_search() {
    const request: IRequest = {
      id: (Math.floor(Math.random() * Number.MAX_SAFE_INTEGER)).toString(),
      location: this.location,
      begin_date: this.begin_date,
      end_date: this.end_date,
      people: this.people
    };
    console.log("Request: "+request.id)
    this.data.search(request);
  }


  constructor(private data: DataService) { }

  ngOnInit() {
  }

}


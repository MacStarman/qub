import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IonDatetime, IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-searchbar',
  standalone: true,
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css'],
  imports: [IonicModule, FormsModule],
})
export class SearchbarComponent implements OnInit {
  isToastOpen = false;
date: any;

  setOpen(isOpen: boolean) {
    this.isToastOpen = isOpen;
  }

  search(arg0: string) {
    console.log(arg0);
  }

  constructor() { }

  ngOnInit() {
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { FormModule } from '@coreui/angular';
import { IonicModule } from '@ionic/angular';
import { NgxStarRatingModule } from 'ngx-star-rating';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css'],
  standalone: true,
  imports: [IonicModule, FormModule, NgxStarRatingModule, ReactiveFormsModule]
})
export class StarRatingComponent implements OnInit {
  @Input()
  rating!: number;
  public form: FormGroup = this.fb.group({
    rating: [this.rating, Validators.required],
  });

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      rating: [this.rating, Validators.required],
    })
  }

}

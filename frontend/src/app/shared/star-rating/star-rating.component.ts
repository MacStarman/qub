import { CommonModule } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { FormModule } from '@coreui/angular';
import { IonicModule } from '@ionic/angular';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css'],
  standalone: true,
  imports: [IonicModule, FormModule, ReactiveFormsModule, CommonModule]
})
export class StarRatingComponent implements OnInit {
  @Input()
  rating!: number;
  stars = [1, 2, 3, 4, 5];
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

import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full',
  },
  {
    path: 'home',
    loadComponent: () => import('./home/home.page').then((m) => m.HomePage),
  },
  {
    path: 'hotel-details/:id',
    loadComponent: () => import('./pages/details-page/details-page.page').then( m => m.DetailsPagePage)
  },
  {
    path: 'add-review',
    loadComponent: () => import('./pages/add-review/add-review.page').then( m => m.AddReviewPage)
  },
];

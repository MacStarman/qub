
export interface Ihotel {
  id: string
  price: Price
  rating: Rating
  description: Description
}

export interface Price {
  hotelId: string
  startDate: string
  endDate: string
  price: number
  bookingId: number
}

export interface Rating {
  id: string
  stars: number
  reviews: Review[]
}

export interface Review {
  hotelId: string
  reviewerName: string
  stars: number
  comment: string
}

export interface Description {
  id: string
  shortDescription: string
  thumbnail: string
  images: string[]
  location: string
  longDescription: string
  popularAttractions: string[]
  facilities: string[]
  hotelLink: string
  publicTransport: string[]
}

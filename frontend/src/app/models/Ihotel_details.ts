import { Ireview } from "./Ireview";

export interface Ihotel_details {
  id: number,
  name: string,
  description: string,
  facilities: string[],
  images: string[],
  reviews: Ireview[]
}

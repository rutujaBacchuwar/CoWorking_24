import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PlansComponent } from './plans/plans.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { OwnerDashboardComponent } from './owner-dashboard/owner-dashboard.component';
import { InformationUpdateComponent} from './information-update/information-update.component'
import { AddPropertiesComponent } from './add-properties/add-properties.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { CardComponent } from './card/card.component';
import { BookingComponent } from './booking/booking.component';
import { ClientProfileComponent } from './client-profile/client-profile.component';

import { PaymentComponent } from './payment/payment.component';
import { SpacesComponent } from './spaces/spaces.component';
import { EditComponent } from './edit/edit.component';
import { ClientBookingComponent } from './client-booking/client-booking.component';

const routes: Routes = [
  {path:'',component:LandingPageComponent},
  {path:'Plans',component:PlansComponent},
  // {path:'location',component:LocationComponent}
  {path:'login',component:LoginComponent},
  {path:'register',component:RegistrationComponent},
  {path:'client-login',component:ClientProfileComponent},
  {path:'client-login/:username',component:ClientProfileComponent},
  {path:'owner-login',component:OwnerDashboardComponent},
  {path:'edit',component:EditComponent},
  {path:'owner-login/:name',component:OwnerDashboardComponent},
  // {path:'add-property',component:AddPropertiesComponent},
  {path:'add-property/:name/:contactNumber/:email',component:AddPropertiesComponent},
  {path:'about',component:AboutUsComponent},
  {path: 'card/:category', component: CardComponent},
  {path: 'details/:spaceName', component:BookingComponent},
  {path: 'detail/:spaceName',component:ClientBookingComponent},
  {path: 'client-dashboard',component:ClientDashboardComponent},
  {path: 'client-dashboard/:username',component:ClientDashboardComponent},

  // {path:'Profile',component:ClientProfileComponent}

  {path: 'pay', component:PaymentComponent},
  {path:'Spaces',component:SpacesComponent}

];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

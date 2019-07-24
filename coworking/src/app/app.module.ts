import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CustomMaterialModule } from './material/material.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PlansComponent } from './plans/plans.component';
import { ImageComponent } from './image/image.component';
import { MidSectionComponent } from './mid-section/mid-section.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LocationComponent } from './location/location.component';
import { MatFormFieldModule} from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { RegistrationComponent } from './registration/registration.component';
import { ClientDashboardComponent } from './client-dashboard/client-dashboard.component';
import { OwnerDashboardComponent } from './owner-dashboard/owner-dashboard.component';
import { AddPropertiesComponent } from './add-properties/add-properties.component';
import { InformationUpdateComponent } from './information-update/information-update.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MatCardModule, MatButtonToggleModule, MatStepperModule, MatInputModule, MatButtonModule, MatSelectModule, MatOptionModule, MatExpansionModule } from '@angular/material';
import { AboutUsComponent } from './about-us/about-us.component';
import { CardComponent } from './card/card.component';
import {HttpClientModule} from '@angular/common/http'
import { CardService } from './card.service';
import { BookingComponent } from './booking/booking.component';
import { ClientProfileComponent } from './client-profile/client-profile.component';
import { ClientImageComponent } from './client-image/client-image.component';
import { ClientMidSectionComponent } from './client-mid-section/client-mid-section.component';
import { PaymentComponent } from './payment/payment.component';
import { SpacesComponent } from './spaces/spaces.component';
import { EditComponent } from './edit/edit.component';
import { BookModalComponent } from './book-modal/book-modal.component';
import { NavbarLogoutComponent } from './navbar-logout/navbar-logout.component';
import { ClientBookingComponent } from './client-booking/client-booking.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    NavbarComponent,
    PlansComponent,
    ImageComponent,
    MidSectionComponent,
    FooterComponent,
    LoginComponent,
    LocationComponent,
    RegistrationComponent,
    ClientDashboardComponent,
    OwnerDashboardComponent,
    AddPropertiesComponent,
    InformationUpdateComponent,
    AboutUsComponent,
    CardComponent,
    BookingComponent,
    ClientProfileComponent,
    ClientImageComponent,
    ClientMidSectionComponent,
    PaymentComponent,
    SpacesComponent,
    EditComponent,
    BookModalComponent,
    NavbarLogoutComponent,
    ClientBookingComponent,
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    
    BrowserAnimationsModule,
    CustomMaterialModule,
    ReactiveFormsModule,
    FormsModule,

    MatCardModule,
    MatButtonToggleModule,
    MatStepperModule, 
    MatInputModule, 
    MatButtonModule,
    MatFormFieldModule,
    MatDialogModule,
    HttpClientModule,
    NgbModule,
    MatSelectModule,
    MatOptionModule,
    MatExpansionModule
    
  ],
  providers: [CardService],
  bootstrap: [AppComponent],
  entryComponents:[LocationComponent,BookModalComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]

})
export class AppModule { }

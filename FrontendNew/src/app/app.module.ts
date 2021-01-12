import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CheckStatusComponent } from './check-status/check-status.component';
import { NetbankingRegistrationComponent } from './netbanking-registration/netbanking-registration.component';
import { ForgotUserIdComponent } from './forgot-user-id/forgot-user-id.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SetNewPasswordComponent } from './set-new-password/set-new-password.component';

import { AdminLoginComponent } from './admin-login/admin-login.component';
<<<<<<< HEAD
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
=======
import { ServicesService } from './services.service';
import { HttpClientModule } from '@angular/common/http';
import { AdminApprovalComponent } from './admin-approval/admin-approval.component';

>>>>>>> d7cdf24f809a3acf64b32561f692052e400f4cab

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    RegistrationPageComponent,
    LoginPageComponent,
    CheckStatusComponent,
    NetbankingRegistrationComponent,
    ForgotUserIdComponent,
    ForgotPasswordComponent,

    SetNewPasswordComponent,

    AdminLoginComponent,

    AdminApprovalComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
<<<<<<< HEAD
    HttpClientModule
=======
    HttpClientModule,
    ReactiveFormsModule
>>>>>>> d7cdf24f809a3acf64b32561f692052e400f4cab
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

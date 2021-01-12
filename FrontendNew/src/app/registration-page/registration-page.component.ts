import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

import { UserDetails } from '../models';
import { ServicesService } from '../services.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  user: UserDetails = new UserDetails();
  loginForm: FormGroup;
  constructor(private service: ServicesService) { }

  register() {
    this.service.register(this.user).subscribe(response => {
      alert(JSON.stringify(response));
    })
  }

  ngOnInit() {
  }

}

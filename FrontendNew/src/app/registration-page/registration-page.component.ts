import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserDetails } from '../models/models';
import { ServicesService } from '../services/services.service';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent implements OnInit {

  
  user: UserDetails = new UserDetails();
  loginForm: FormGroup;
  error_messages = {
    'fname': [
      { type: 'required', message: 'First Name is required.' },
    ],
    'lname': [
      { type: 'required', message: 'Last Name is required.' },
    ],
    'faname': [
      { type: 'required', message: 'Father Name is required.' },
    ],
    'maname': [
      { type: 'required', message: 'Mother Name is required.' },
    ],
    'mo': [
      { type: 'required', message: 'Mobile Number is required.' },
      { type: 'required', message: 'Mobile Number Should be of 10 digit' },
    ],
    'em': [
      { type: 'required', message: 'Email is required.' },
    ],
    'ad': [
      { type: 'required', message: 'Aadhar Number is required.' },
      { type: 'maxLength', message: 'Aadhar Number Should be of 12 digit' },
      { type: 'minLength', message: 'Aadhar Number Should be of 12 digit' },
    ],
    'add': [
      { type: 'required', message: 'Address is required.' },
    ],
    'da': [
      { type: 'required', message: 'Address is required.' },
    ],
    'st': [
      { type: 'required', message: 'State is required.' },
    ],
    'ci': [
      { type: 'required', message: 'City is required.' },
    ],
    'pi': [
      { type: 'required', message: 'Pincode is required.' },
    ],
    'ri': [
      { type: 'required', message: 'Address is required.' },
    ],
    'an': [
      { type: 'required', message: 'Address is required.' },
    ],
    'rk': [
      { type: 'required', message: 'State is required.' },
    ],
    'aj': [
      { type: 'required', message: 'City is required.' },
    ],
    'ar': [
      { type: 'required', message: 'Pincode is required.' },
    ]
    
  
  }

  constructor(
    private http: HttpClient,
    public formBuilder: FormBuilder,
    private service: ServicesService,
    private router: Router
    ) {
      this.loginForm = this.formBuilder.group({
        fname: new FormControl('', Validators.compose([
          Validators.required 
        ])),
        lname: new FormControl('', Validators.compose([
          Validators.required
        ])),
        faname: new FormControl('', Validators.compose([
          Validators.required
        ])),
        maname: new FormControl('', Validators.compose([
          Validators.required
        ])),
        mo: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10)
          
        ])),
        em: new FormControl('', Validators.compose([
          Validators.required
        ])),
       
        ad: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(12),
          Validators.maxLength(12)
        ])),
        add: new FormControl('', Validators.compose([
          Validators.required
        ])),
        da: new FormControl('', Validators.compose([
          Validators.required
        ])),
        st: new FormControl('', Validators.compose([
          Validators.required
        ])),
        ci: new FormControl('', Validators.compose([
          Validators.required
        ])),
        pi: new FormControl('', Validators.compose([
          Validators.required,
          Validators.minLength(6),
          Validators.maxLength(6)
        ]))
       
        
       /* ri: new FormControl('', Validators.compose([
          Validators.required
        ])),
        an: new FormControl('', Validators.compose([
          Validators.required
        ])),
        rk: new FormControl('', Validators.compose([
          Validators.required
        ])),
        aj: new FormControl('', Validators.compose([
          Validators.required
        ])),
        ar: new FormControl('', Validators.compose([
          Validators.required
        ]))*/
      });
     }

  ngOnInit(): void {
  }

  /*titles = ['Mr.', 'Mrs.' , 'Ms.'];
  occupations = ['Profession', 'Employment', 'Business'];
  sources = ['Earned', 'Interest', 'Profit', 'Dividend', 'Rental', 'Royalty' ];
  incomes = ['Less then 5LPA', '5LPA-10LPA', '10LPA-25LPA', '25LPA and More'];
*/
  // result = "";
  // line1 = "";
  // line2 = "";
  // landmark = "";
  // state = "";
  // city = "";
  // code = "";

    // checkAdress() {
    //   var checkBox = document.getElementById("defaultCheck1");
    //   if(this.result==""){
    //     this.line1 = ((document.getElementById("resLine1") as HTMLInputElement).value);
    //     this.line2 = ((document.getElementById("resLine2") as HTMLInputElement).value);
    //     this.landmark = ((document.getElementById("resLandmark") as HTMLInputElement).value);
    //     this.state = ((document.getElementById("resState") as HTMLInputElement).value);
    //     this.city = ((document.getElementById("resCity") as HTMLInputElement).value);
    //     this.code = ((document.getElementById("resCode") as HTMLInputElement).value);
    //     this.result = "disabled";
    //   }
    //   else {
    //     this.result = "";
    //     this.line1 = "";
    //     this.line2 = "";
    //     this.landmark = "";
    //     this.state = "";
    //     this.city = "";
    //     this.code = "";
    //   }
    // }

    register() {
      this.service.register(this.user).subscribe(response => {
        if (response.status=="FAILED")
        { 
          
            alert(JSON.stringify(response.message))
            this.router.navigate(['userLogin'])
        }  
          else{
            alert(JSON.stringify(response.message));
            this.router.navigate(['']);
          }
        
        
      })
      
    }

}

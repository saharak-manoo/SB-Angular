import { Component } from '@angular/core';
import { AppComponent } from '../app/app.component';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [LoginService]
})
export class LoginComponent {
  constructor(public app: AppComponent, private route: ActivatedRoute, private router: Router, private loginService: LoginService) {}
  signInForm: FormGroup;
  isLoading: boolean = false;
  username: string = null;
  password: string = null;

  ngOnInit() {
    this.signInForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });
  }

  hasError = (controlName: string, errorName: string) => {
    return this.signInForm.controls[controlName].hasError(errorName);
  };

  onSubmit() {
    if (this.signInForm.invalid) {
      return;
    }
    this.isLoading = true;
    let params = {
      username: this.username,
      password: this.password
    };
    this.loginService.signIn(params).subscribe(
      resp => {
        this.isLoading = false;
        console.log(resp);
        this.router.navigate([`/home`]);
        this.app.showSnackBar('Login done..', 'Close', 'green-snackbar');
      },
      e => {
        this.isLoading = false;
        console.log(e);
        this.app.showSnackBar(e.message, 'Close', 'red-snackbar');
      }
    );
  }
}

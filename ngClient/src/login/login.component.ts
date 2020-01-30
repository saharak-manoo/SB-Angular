import { Component } from '@angular/core';
import { AppComponent } from '../app/app.component';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from './login.service';

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [LoginService]
})
export class LoginComponent {
  constructor(public app: AppComponent, private route: ActivatedRoute, private router: Router, private loginService: LoginService) {}

  ngOnInit() {}

  signIn() {
    let params = {
      username: 'saharak',
      password: 'password'
    };
    this.loginService.signIn(params).subscribe(
      resp => {
        console.log(resp);
      },
      e => {
        console.log(e);
      }
    );
    this.router.navigate([`/home`]);
    this.app.showSnackBar('Login done..', 'Close', 'green-snackbar');
  }
}

import { Component } from '@angular/core';
import { AppComponent } from '../app/app.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  constructor(public app: AppComponent, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {}

  logIn() {
    this.router.navigate([`/home`]);
    this.app.showSnackBar('Login done..', 'Close', 'green-snackbar');
  }
}

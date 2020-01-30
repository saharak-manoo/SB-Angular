import { Component } from '@angular/core';
import { MatSnackBar, ErrorStateMatcher } from '@angular/material';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(public snackBar: MatSnackBar, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    let token = localStorage.getItem('token');
    if (token === null) {
      this.router.navigate([`/login`]);
    } else {
      this.router.navigate([`/home`]);
    }
  }

  showSnackBar(message, action, className) {
    this.snackBar.open(message, action, {
      duration: 5000,
      panelClass: [className],
      verticalPosition: 'top',
      horizontalPosition: 'right'
    });
  }
}

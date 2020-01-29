import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  constructor() {}
  roles: any = ['Admin', 'Author', 'Reader'];

  ngOnInit() {}
}

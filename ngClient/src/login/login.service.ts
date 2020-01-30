import { Injectable, isDevMode } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { environment } from '../environments/environment';

@Injectable()
export class LoginService {
  constructor(protected http: HttpClient) {}

  signIn(params) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json;'
    });
    return this.http.post(`${environment.host}/api/v1/sign-in`, params, {
      headers: headers
    });
  }
}

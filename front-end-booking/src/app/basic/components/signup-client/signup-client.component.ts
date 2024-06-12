import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-client',
  templateUrl: './signup-client.component.html',
  styleUrl: './signup-client.component.scss'
})
export class SignupClientComponent {
  validateForm!: FormGroup;

  constructor(private fb: FormBuilder,
    private authService: AuthService,
    private notification: MatSnackBar,
    private router: Router) {}

    ngOnInit() {
      this.validateForm = this.fb.group({
        email: [null, [Validators.email, Validators.required]],
        name: [null, [Validators.required]],
        lastname: [null, [Validators.required]],
        phone: [null],
        password: [null, [Validators.required]],
        checkPassword: [null, [Validators.required]],
      })
    }

    submitForm() {
      this.authService.registerClient(this.validateForm.value).subscribe(res => {
        this.notification.open('Signup successful', '', { duration: 3000 });
        this.router.navigateByUrl('/login');
      }, error => {
        this.notification.open('Error', '', { duration: 3000 });
      });
    }
}

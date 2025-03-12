import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ConsultaCreditosComponent } from './components/consulta-creditos/consulta-creditos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ConsultaCreditosComponent
  ],
  template: `
    <div class="container">
      <h1>Sistema de Consulta de Créditos</h1>
      <app-consulta-creditos></app-consulta-creditos>
    </div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title(title: any) {
    throw new Error('Method not implemented.');
  }
}
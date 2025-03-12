import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreditoService } from '../../services/credito.service';
import { Credito } from '../../models/credito.model';

@Component({
  selector: 'app-consulta-creditos',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './consulta-creditos.component.html',
  styleUrls: ['./consulta-creditos.component.css']
})
export class ConsultaCreditosComponent {
  numeroNfse: string = '';
  numeroCredito: string = '';
  creditos: Credito[] = [];
  credito: Credito | null = null;
  mensagemErro: string = '';

  constructor(private creditoService: CreditoService) { }

  consultarPorNfse() {
    this.creditoService.getCreditosByNfse(this.numeroNfse).subscribe(
      data => {
        this.creditos = data;
        this.credito = null;
        this.mensagemErro = '';
      },
      error => {
        this.mensagemErro = 'Nenhum crédito encontrado para o número da NFS-e informado.';
        this.creditos = [];
      }
    );
  }
  consultarPorCredito() {
    if (this.numeroCredito) {
      this.creditoService.getCreditoByNumero(this.numeroCredito).subscribe(
        data => {
          this.creditos = data; 
          this.credito = null;; 
          this.mensagemErro = ''; 
        },
        error => {
          this.mensagemErro = 'Nenhum crédito encontrado para o número informado.';
          this.creditos = [];
        }
      );
    } else {
      this.mensagemErro = 'Por favor, insira um número de crédito válido.';
    }
  }
}
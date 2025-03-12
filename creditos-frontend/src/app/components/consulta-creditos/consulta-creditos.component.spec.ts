import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ConsultaCreditosComponent } from './consulta-creditos.component';
import { CreditoService } from '../../services/credito.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';

describe('ConsultaCreditosComponent', () => {
  let component: ConsultaCreditosComponent;
  let fixture: ComponentFixture<ConsultaCreditosComponent>;
  let creditoService: CreditoService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsultaCreditosComponent],
      imports: [HttpClientTestingModule, FormsModule],
      providers: [CreditoService]
    });
    fixture = TestBed.createComponent(ConsultaCreditosComponent);
    component = fixture.componentInstance;
    creditoService = TestBed.inject(CreditoService);
    fixture.detectChanges();
  });

  it('deve criar o componente', () => {
    expect(component).toBeTruthy();
  });

  it('deve chamar o serviço ao consultar por NFS-e', () => {
    spyOn(creditoService, 'getCreditosByNfse').and.callThrough();
    component.numeroNfse = '7891011';
    component.consultarPorNfse();
    expect(creditoService.getCreditosByNfse).toHaveBeenCalledWith('7891011');
  });
});
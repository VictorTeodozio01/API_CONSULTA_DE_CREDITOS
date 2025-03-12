import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CreditoService } from './credito.service';
import { Credito } from '../models/credito.model';

describe('CreditoService', () => {
  let service: CreditoService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CreditoService]
    });
    service = TestBed.inject(CreditoService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('deve retornar créditos por NFS-e', () => {
    const mockCreditos: Credito[] = [
      { numeroCredito: '123456', numeroNfse: '7891011', dataConstituicao: '2024-02-25', valorIssqn: 1500.75, tipoCredito: 'ISSQN', simplesNacional: true, aliquota: 5.0, valorFaturado: 30000.00, valorDeducao: 5000.00, baseCalculo: 25000.00 }
    ];

    service.getCreditosByNfse('7891011').subscribe(creditos => {
      expect(creditos.length).toBe(1);
      expect(creditos).toEqual(mockCreditos);
    });

    const req = httpMock.expectOne('http://localhost:8080/api/creditos/7891011');
    expect(req.request.method).toBe('GET');
    req.flush(mockCreditos);
  });
});
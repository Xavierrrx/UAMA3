import { Injectable } from '@angular/core';
import { Avaliacao } from '../models/avaliacao';
import { ResourceService } from 'src/app/services/resource.service';
import { HttpClient } from '@angular/common/http';
import { AvaliacaoPreenchida } from '../models/avaliacao-preenchida';
import { Observable } from 'rxjs';
import { Pageable } from 'src/app/util/pageable-request';

@Injectable({
  providedIn: 'root',
})
export class AvaliacaoService extends ResourceService<Avaliacao>{

  constructor(private http: HttpClient) {
    super(http, `/api/avaliacoes`);
  }

  realizarAvaliacao(avaliacao: AvaliacaoPreenchida): Observable<any> {
    return this.http.put('/api/avaliacoes/realizada', avaliacao);
  }

}

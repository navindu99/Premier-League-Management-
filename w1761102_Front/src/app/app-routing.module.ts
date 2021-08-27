import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DateSortComponent } from './date-sort/date-sort.component';
import { FindMatchComponent } from './find-match/find-match.component';
import { GenerateMatchComponent } from './generate-match/generate-match.component';
import { PlayMatchComponent } from './play-match/play-match.component';
import { TableGoalsComponent } from './table-goals/table-goals.component';
import { TablePointsComponent } from './table-points/table-points.component';
import { TableWinsComponent } from './table-wins/table-wins.component';
import { TablesComponent } from './tables/tables.component';

const routes: Routes = [
    {path: 'TableGoals', component:TableGoalsComponent},
    {path: 'TablePoints', component:TablePointsComponent},
    {path: 'TableWins', component:TableWinsComponent},
    {path: 'PlayMatch', component:PlayMatchComponent},
    {path: 'FindMatch',component:FindMatchComponent},
    {path: 'Tables', component:TablesComponent},
    {path: 'FindMatch', component:FindMatchComponent},
    {path: 'PlayMatch', component:PlayMatchComponent},
    {path: 'DateSort', component:DateSortComponent},
    {path: 'GenerateMatch', component:GenerateMatchComponent}
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
  export class AppRoutingModule { }
  export const routingComponents = [GenerateMatchComponent, FindMatchComponent, PlayMatchComponent, DateSortComponent, TablesComponent,TablePointsComponent,TableGoalsComponent,TableWinsComponent,PlayMatchComponent]

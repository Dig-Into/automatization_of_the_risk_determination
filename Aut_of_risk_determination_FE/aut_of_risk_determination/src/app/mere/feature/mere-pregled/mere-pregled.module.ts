import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormsModule } from "@angular/forms";
import { MatTableModule } from "@angular/material/table";
import { MerePregledComponent } from "./mere-pregled.component";
import { MerePregledRoutingModule } from "./mere-pregled-routing.module";
import { SharedModule } from "src/app/shared/shared.module";
import { MatPaginatorModule } from "@angular/material/paginator";

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        MerePregledRoutingModule,
        MatTableModule,
        SharedModule,
        MatPaginatorModule
    ],
    declarations: [MerePregledComponent]
})

export class MerePregledModule {}
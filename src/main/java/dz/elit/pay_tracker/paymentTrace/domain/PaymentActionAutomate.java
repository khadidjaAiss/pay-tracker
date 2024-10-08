package dz.elit.pay_tracker.paymentTrace.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "ctc_automate_synchronisation", schema = "sch_ctc")
@Data
@NoArgsConstructor
public class PaymentActionAutomate implements Serializable {

        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Column(name = "mode_paiement")
        private String modePaiement;
        @Column(name = "code_action")
        private String codeAction;
        @Column(name = "etat_parent_ctc")
        private String etatParentCtc;
        @Column(name = "etat_parent_hors_ctc")
        private String etatParentHorsCtc;
}

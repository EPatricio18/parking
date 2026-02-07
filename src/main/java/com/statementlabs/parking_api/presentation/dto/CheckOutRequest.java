package presentation.dto;

import jakarta.validation.constraints.NotNull;

public class CheckOutRequest {
    @NotNull(message = "ID do ticket é obrigatório")
    private Long ticketId;

    public Long getTicketId() { return ticketId; }
    public void setTicketId(Long ticketId) { this.ticketId = ticketId; }
}
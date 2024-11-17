const backendUrl = "http://localhost:8080"; // Replace with your backend URL

document.addEventListener("DOMContentLoaded", () => {
    const createAccountForm = document.getElementById("create-account-form");

    if (createAccountForm) {
        createAccountForm.addEventListener("submit", async (e) => {
            e.preventDefault(); // Prevent default form submission

            const name = document.getElementById("name").value.trim();
            const initialDeposit = document.getElementById("initial-deposit").value.trim();

            if (!name || !initialDeposit) {
                alert("Please fill out all fields!");
                return;
            }

            try {
                const response = await fetch(${backendUrl}/api/accounts, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({ name, balance: parseFloat(initialDeposit) }),
                });

                const result = await response.json();

                if (response.ok) {
                    document.getElementById("create-account-message").textContent = "Account created successfully!";
                    createAccountForm.reset();
                } else {
                    document.getElementById("create-account-message").textContent = result.message || "Failed to create account.";
                }
            } catch (error) {
                document.getElementById("create-account-message").textContent = "Error: Unable to connect to the server.";
            }
        });
    }
});
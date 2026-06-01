// BACKEND BASE URL
const BASE_URL = "http://localhost:8080/api";


// PAGE LOAD
window.onload = function () {

    loadPlanNames();
    loadPlanStatus();
};


// LOAD PLAN NAMES
async function loadPlanNames() {

    try {

        const response = await fetch(`${BASE_URL}/plans`);

        const plans = await response.json();

        const planDropdown =
            document.getElementById("planName");

        plans.forEach(plan => {

            const option =
                document.createElement("option");

            option.value = plan;

            option.text = plan;

            planDropdown.appendChild(option);
        });

    } catch (error) {

        console.error(
            "Error loading plan names:",
            error
        );
    }
}


// LOAD PLAN STATUS
async function loadPlanStatus() {

    try {

        const response = await fetch(`${BASE_URL}/status`);

        const statuses = await response.json();

        const statusDropdown =
            document.getElementById("planStatus");

        statuses.forEach(status => {

            const option =
                document.createElement("option");

            option.value = status;

            option.text = status;

            statusDropdown.appendChild(option);
        });

    } catch (error) {

        console.error(
            "Error loading statuses:",
            error
        );
    }
}


// SEARCH REPORTS
async function searchReports() {

    const searchData = {

        planName: document.getElementById("planName").value || null,
    planStatus: document.getElementById("planStatus").value || null,
    gender: document.getElementById("gender").value || null,
    startDate: document.getElementById("startDate").value || null,
    endDate: document.getElementById("endDate").value || null
    };

    try {

        const response = await fetch(
            `${BASE_URL}/search`,
            {
                method: "POST",

                headers: {
                    "Content-Type": "application/json"
                },

                body: JSON.stringify(searchData)
            }
        );

        const data = await response.json();
        console.log(data.body);
        
        renderTable(data);

    } catch (error) {

        console.error(
            "Search Error:",
            error
        );
    }
}


// RENDER TABLE
function renderTable(data) {

    const tableBody =
        document.getElementById("reportTableBody");

    tableBody.innerHTML = "";

    // NO DATA
    if (data.length === 0) {

        tableBody.innerHTML = `
            <tr>
                <td colspan="8" class="no-data">
                    No Records Found
                </td>
            </tr>
        `;

        return;
    }

    // DISPLAY DATA
    data.forEach(report => {

        const row = `
            <tr>

                <td>${report.citizenName || ''}</td>

                <td>${report.gender || ''}</td>

                <td>${report.planName || ''}</td>

                <td>${report.planStatus || ''}</td>

                <td>${report.benefitAmount || ''}</td>

                <td>${report.planStartDate || ''}</td>

                <td>${report.planEndDate || ''}</td>

                <td>${report.denialReason || ''}</td>

            </tr>
        `;
             
        tableBody.innerHTML += row;
    });
}


// EXPORT EXCEL
function downloadExcel() {

    window.open(
        `${BASE_URL}/export/excel`,
        "_blank"
    );
}


// EXPORT PDF
function downloadPdf() {

    window.open(
        `${BASE_URL}/export/pdf`,
        "_blank"
    );
}
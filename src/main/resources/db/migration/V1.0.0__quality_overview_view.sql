create table if not exists quality_overview_view
(
    quality_overview_id     uuid                not null,
    total_amount_of_models  integer             not null,
    primary key (quality_overview_id)
);
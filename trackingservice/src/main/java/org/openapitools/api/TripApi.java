/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0-beta).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.Trip;
import org.openapitools.model.TripProgress;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-30T17:09:16.737885200+05:30[Asia/Calcutta]")
@Validated
@Tag(name = "Trip", description = "Assignment of a route to an operator forms a trip. This is the actual work done by the operator. Monitoring of distance covered, route taken, anomalies, service delivery and payment are linked to completion of trip.")
public interface TripApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /trip/_create : Create a new trip based on the required set of parameters
     * Create a new trip by Id
     *
     * @param trip Create a new Trip in the system (required)
     * @return Successful operation (status code 200)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "createTrip",
        summary = "Create a new trip based on the required set of parameters",
        description = "Create a new trip by Id",
        tags = { "Trip" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Trip.class))
            }),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/trip/_create",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Trip> createTrip(
        @Parameter(name = "Trip", description = "Create a new Trip in the system", required = true) @Valid @RequestBody Trip trip
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"routeId\" : \"routeId\", \"actualStartTime\" : \"2023-07-30T10:24:10.547Z\", \"plannedStartTime\" : \"2023-07-30T10:24:10.547Z\", \"serviceCode\" : \"serviceCode\", \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"plannedEndTime\" : \"2023-07-30T10:24:10.547Z\", \"actualEndTime\" : \"2023-07-30T10:24:10.547Z\", \"operator\" : { \"name\" : \"name\", \"contactNumber\" : \"contactNumber\", \"vehicleNumber\" : \"vehicleNumber\", \"id\" : \"id\", \"email\" : \"email\" }, \"status\" : \"created\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /trip/_search : Find trip using supported parameters
     * Search Trip based on multiple filters
     *
     * @param status Status values that need to be considered for filter (optional, default to active)
     * @param tripName Trip name that needs to be considered for filter (optional)
     * @return successful operation (status code 200)
     *         or Invalid search value (status code 400)
     */
    @Operation(
        operationId = "findTrip",
        summary = "Find trip using supported parameters",
        description = "Search Trip based on multiple filters",
        tags = { "Trip" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Trip.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid search value")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/trip/_search",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Trip>> findTrip(
        @Parameter(name = "status", description = "Status values that need to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "status", required = false, defaultValue = "active") String status,
        @Parameter(name = "tripName", description = "Trip name that needs to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "tripName", required = false) String tripName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"routeId\" : \"routeId\", \"actualStartTime\" : \"2023-07-30T10:24:10.547Z\", \"plannedStartTime\" : \"2023-07-30T10:24:10.547Z\", \"serviceCode\" : \"serviceCode\", \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"plannedEndTime\" : \"2023-07-30T10:24:10.547Z\", \"actualEndTime\" : \"2023-07-30T10:24:10.547Z\", \"operator\" : { \"name\" : \"name\", \"contactNumber\" : \"contactNumber\", \"vehicleNumber\" : \"vehicleNumber\", \"id\" : \"id\", \"email\" : \"email\" }, \"status\" : \"created\" }, { \"routeId\" : \"routeId\", \"actualStartTime\" : \"2023-07-30T10:24:10.547Z\", \"plannedStartTime\" : \"2023-07-30T10:24:10.547Z\", \"serviceCode\" : \"serviceCode\", \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"plannedEndTime\" : \"2023-07-30T10:24:10.547Z\", \"actualEndTime\" : \"2023-07-30T10:24:10.547Z\", \"operator\" : { \"name\" : \"name\", \"contactNumber\" : \"contactNumber\", \"vehicleNumber\" : \"vehicleNumber\", \"id\" : \"id\", \"email\" : \"email\" }, \"status\" : \"created\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /trip/{tripId} : Find trip by its id
     * Returns a single Route
     *
     * @param tripId ID of Trip to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Trip not found (status code 404)
     */
    @Operation(
        operationId = "getTripById",
        summary = "Find trip by its id",
        description = "Returns a single Route",
        tags = { "Trip" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Trip.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Trip not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/trip/{tripId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Trip> getTripById(
        @Parameter(name = "tripId", description = "ID of Trip to return", required = true, in = ParameterIn.PATH) @PathVariable("tripId") String tripId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"routeId\" : \"routeId\", \"actualStartTime\" : \"2023-07-30T10:24:10.547Z\", \"plannedStartTime\" : \"2023-07-30T10:24:10.547Z\", \"serviceCode\" : \"serviceCode\", \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"plannedEndTime\" : \"2023-07-30T10:24:10.547Z\", \"actualEndTime\" : \"2023-07-30T10:24:10.547Z\", \"operator\" : { \"name\" : \"name\", \"contactNumber\" : \"contactNumber\", \"vehicleNumber\" : \"vehicleNumber\", \"id\" : \"id\", \"email\" : \"email\" }, \"status\" : \"created\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /trip/_progress : Provide geo location update of the operator who is on move.
     * Update an existing trip by Id
     *
     * @param tripProgress Update an existent trip in the system (required)
     * @return Successful operation (status code 200)
     *         or Invalid Trip ID is supplied (status code 400)
     *         or Trip not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "progressTrip",
        summary = "Provide geo location update of the operator who is on move.",
        description = "Update an existing trip by Id",
        tags = { "Trip" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Trip ID is supplied"),
            @ApiResponse(responseCode = "404", description = "Trip not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/trip/_progress",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> progressTrip(
        @Parameter(name = "TripProgress", description = "Update an existent trip in the system", required = true) @Valid @RequestBody TripProgress tripProgress
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /trip/_update : Update details of an existing trip using its id. Updatable fields include its service code, planned schedule, route id and operator id
     * Update an existing trip by Id
     *
     * @param trip Update an existent trip in the system (required)
     * @return Successful operation (status code 200)
     *         or Invalid Trip ID is supplied (status code 400)
     *         or Trip not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updateTrip",
        summary = "Update details of an existing trip using its id. Updatable fields include its service code, planned schedule, route id and operator id",
        description = "Update an existing trip by Id",
        tags = { "Trip" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid Trip ID is supplied"),
            @ApiResponse(responseCode = "404", description = "Trip not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/trip/_update",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateTrip(
        @Parameter(name = "Trip", description = "Update an existent trip in the system", required = true) @Valid @RequestBody Trip trip
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
